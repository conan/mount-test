(ns mount-test.web
  (:require [mount.core :refer [defstate]]
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

(defstate web-server
  :start (start 4321)
  :stop (web-server))