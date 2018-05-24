(defproject mount-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[clj-http "3.9.0"]
                 [http-kit "2.3.0"]
                 [metosin/reitit "0.1.1"]
                 [mount "0.1.12"]
                 [org.clojure/clojure "1.9.0"]]
  :repl-options {:init-ns mount-test.core})
