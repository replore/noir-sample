(ns noir-sample.views.orenoimouto
  (:require [noir-sample.views.common :as common]
	    [ring.util.response :as resp]
 	    [cheshire.core :as json]
 	    [clj-http.client :as client]
            [noir.content.getting-started])
  (:use [noir.core]
        [hiccup.core]
	[hiccup.page-helpers]))


(def base-uri "http://oreno.imouto.org/tag/index.json?")
(def oreno-uri "http://oreno.imouto.org/tag/index.json?name=&type=4&order=count")
(def oreno-tag-uri "http://oreno.imouto.org/post/index")
(def tag-fields ["count" "name"])
(def page-limit 50)

;; should use hiccup utility when making uri
(defpartial link-to-orenoimouto-contents [name count]
  [:li (link-to (str oreno-tag-uri "?tags=" name) name)]
  [:li count]
  [:li
   [:img {"src" (common/convert-jpg-to-URL (str name))}]])


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
       (map (fn [tag] (link-to-orenoimouto-contents (tag "name") (tag "count"))) (drop (* page-limit (- page 1)) json-data)))
      ]))


(defpage "/orenoimouto/:page" {:keys [page]}
    (orenoimouto-jpg-to-pages (str oreno-uri "&limit=" (* page-limit (Integer/parseInt page))) (Integer/parseInt page)))

(defpage "/orenoimouto" []
  (resp/redirect "/orenoimouto/1"))




