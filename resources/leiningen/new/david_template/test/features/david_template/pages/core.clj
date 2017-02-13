(ns {{name}}.pages.core
  (:require [{{name}}.server :refer :all]
            [ring.adapter.jetty :refer :all])
  (:import org.openqa.selenium.chrome.ChromeDriver))

(def driver (atom nil))
(def server (atom nil))

(defn setup []
  (reset! server (run-jetty http-handler {:port 3450 :join? false}))
  (reset! driver (ChromeDriver.))
  (.get @driver "localhost:3450/"))

(defn teardown []
  (.quit @driver)
  (reset! driver nil)
  (.stop @server)
  (reset! server nil))
