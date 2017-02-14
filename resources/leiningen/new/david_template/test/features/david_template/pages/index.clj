(ns {{name}}.pages.index
  (:import org.openqa.selenium.By)
  (:require [{{name}}.pages.core :refer [driver server]]))

(defn enter-name [name] 
  (-> @driver
      (.findElement (. By name "name"))
      (.sendKeys (into-array [name]))))

(defn greeting [] 
  (-> @driver
      (.findElement (. By cssSelector ".greeter__greeting"))
      (.getText)))
