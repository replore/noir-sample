(ns noir-sample.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "noir-sample"]
               (include-css "/css/reset.css")]
              [:body
               [:div#wrapper
                content]]))


;; Utility method
(defn convert-jpg-to-URL [name]
  (str "http://" name ".jpg.to"))

(defpartial jpg-to-page [name]
  (layout
   [:h1 (str name)]
   [:img {"src" (convert-jpg-to-URL name)}]))


(defpartial link-jpg-to-src [name]
  [:li name]
  [:li
   [:img {"src" (convert-jpg-to-URL (str name))}]])
