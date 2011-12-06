(ns noir-sample.views.orenoimouto
  (:require [noir-sample.views.common :as common]
 	    [cheshire.core :as json]
 	    [clj-http.client :as client]
            [noir.content.getting-started])
  (:use [noir.core]
        [hiccup.core]
	[hiccup.page-helpers]))


(def base-uri "http://oreno.imouto.org/tag/index.json?")
(def oreno-uri "http://oreno.imouto.org/tag/index.json?name=&type=4&order=count")
(def tag-fields ["count" "name"])

(defpartial orenoimouto-jpg-to-page [url]
   (common/layout
    [:h1 "Orenoimouto sample (jpg.to)"]
    [:h1 "Using Oreno Imouto API"]
    [:ul
     (let [json-data (json/parse-string (:body (client/get url)))]
       (map (fn [tag] (common/link-jpg-to-src (tag "name"))) json-data))
      ]))

(defpartial orenoimouto-jpg-to-pages [url page]
   (common/layout
    [:h1 "Orenoimouto sample (jpg.to)"]
    [:h1 "Using Oreno Imouto API"]
    [:ul
     (let [json-data (json/parse-string (:body (client/get url)))]
       (map (fn [tag] (common/link-jpg-to-src (tag "name"))) (drop (* 50 (- page 1)) json-data)))
      ]))


(defpage "/orenoimouto" []
  (orenoimouto-jpg-to-page oreno-uri))


(defpage "/orenoimouto/:page" {:keys [page]}
    (orenoimouto-jpg-to-pages (str oreno-uri "&limit=" (* 50 (Integer/parseInt page))) (Integer/parseInt page)))


