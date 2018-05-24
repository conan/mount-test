(ns mount-test.core
  (:require [clj-http.client :as http]
            [mount-test.web :as web]
            [mount.core :as mount]
            [reitit.ring :as rr]))

(mount/start)
