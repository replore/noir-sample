(defproject noir-sample "0.1.0-SNAPSHOT"
            :description "FIXME: write this!"
            :dependencies [[org.clojure/clojure "1.3.0"]
			   [cheshire "2.0.2"]
			   [org.clojure/clojure-contrib "1.2.0"]
                           [noir "1.2.1"]]
	    :jvm-opts ["-Dfile.encoding=UTF8"]
            :main noir-sample.server)

