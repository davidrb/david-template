(ns {{name}}.core
  (:require [reagent.core :as r])
  (:require-macros [devcards.core :refer [defcard-rg]]))

(defn greeter 
  [name]
  [:div.greeter
      [:span.greeter__greeting (if (= "" @name) 
                                   "Hello!"
                                   (str "Hello, " @name "!"))]
      [:div.greeter__name-container
        [:label.greeter__name-label "Your Name: "]
        [:input.greeter__name {:name "name"
                 :value @name
                 :on-change #(reset! name (-> % .-target .-value))}]]])

(defcard-rg greeter-card
  [greeter (r/atom "World")])

(defonce greeter-name (r/atom ""))

(defn ^:export main []
  (r/render [greeter greeter-name]
            (js/document.getElementById "app")))

(defn js-reload []
  (main))
