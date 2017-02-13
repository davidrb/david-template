(ns {{name}}.core
  (:require [reagent.core :as r])
  (:require-macros [devcards.core :refer [defcard-rg]]))

(defn simple-component []
  [:div.simple-component 
    [:p "I am a component!"]
    [:p "I have "
        [:span.simple-component__bold "bold "]
        [:span.simple-component__red "and red "]
        "text!"]])

(defcard-rg simple-component-card
  [simple-component])

(defn ^:export main []
  (r/render [simple-component]
            (js/document.getElementById "app")))

(defn js-reload []
  (main))
