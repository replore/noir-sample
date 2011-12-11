(ns noir-sample.views.twitter
  (:require [noir-sample.views.common :as common]
	    [ring.util.response :as resp]
 	    [cheshire.core :as json]
 	    [clj-http.client :as client]
            [noir.content.getting-started])
  (:use [noir.core]
        [hiccup.core]
	[hiccup.page-helpers]
	[twitter.oauth]
	[twitter.callbacks]
	[twitter.callbacks.handlers]
	[twitter.api.restful])
  (:import
   (twitter.callbacks.protocols SyncSingleCallback)))


(defpartial twitter-sample []
  (common/layout
   [:h1 "Twitter sample"]
   [:h2 "This is Twitter Public timeline"]
   [:ul
   (let [tl (:body (public-timeline))]
     (for [t tl]
       [:li (:text t)]
;;	[:ul (:text t)]]
     ))
    ]))


(defpage "/twitter" []
  (twitter-sample))




