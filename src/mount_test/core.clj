(ns mount-test.core
  (:require [clj-http.client :as http]
            [mount.core :as mount]
            [org.httpkit.server :as server]
            [reitit.ring :as rr]))

(defn app
  []
  (rr/ring-handler
    (rr/router
      ["/" {:get (constantly {:status 200 :body "hi there"})}])
    (rr/create-default-handler)))

(defn start
  [port]
  (server/run-server (app) port))

(mount/defstate web-server
  :start (start 4321)
  :stop (web-server))

(prn "Starting" (mount/start))
(prn "HTTP request:")
(prn (http/get "http://localhost:4321"))