(import 'org.openqa.selenium.chrome.ChromeDriver)

(use '{{name}}.server)
(use 'ring.adapter.jetty)

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
