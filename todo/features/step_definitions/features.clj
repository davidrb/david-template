(ns todo.features
  (:require [todo.server :refer :all]
            [cucumber.runtime.clj :refer :all]
            [ring.adapter.jetty :refer :all]))

(import 'org.openqa.selenium.chrome.ChromeDriver)

(def driver (atom nil))
(def server (atom nil))

(Before []
  (reset! server
                    (run-jetty http-handler {:port 3450 :join? false}))
  (reset! driver (ChromeDriver.))
  (.get @driver "localhost:3450/"))

(After []
         (.quit @driver)
         (reset! driver nil)
         (.stop @server)
         (reset! server nil))

(Then #"^The title should be (.+)$" [title]
        (assert (= title (.getTitle @driver))
                          (str "Expected title to be " title
                                              ", was " (.getTitle @driver))))
