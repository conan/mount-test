(ns mount-test.core
  (:require [clj-http.client :as http]
            [mount.core :as mount]
            [org.httpkit.server :as server]
            [reitit.ring :as rr]
            [clojure.spec.alpha :as s]))

(defn app
  []
  (rr/ring-handler
    (rr/router
      ["/" {:get (constantly {:status 200 :body "hi there"})}])
    (rr/create-default-handler)))

(defn start
  [port]
  (println "Starting on port " port)
  (server/run-server (app) port))

(s/fdef start
  :args (s/cat :port int?)
  :ret (s/fspec :args (s/cat)))

(mount/defstate web-server
  :start (start 4321)
  :stop (web-server))

(prn (mount/start))

(comment
  (http/get "http://localhost:4321"))