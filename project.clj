(defproject mdview "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [markdown-clj "0.9.85"]
                 [seesaw "1.4.5"]
                 [clj-http "2.0.1"]
                 [enlive "1.1.6"]]
  :main ^:skip-aot mdview.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
