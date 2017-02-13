(ns {{name}}.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]))

(enable-console-print!)

(re-frame/reg-sub   ;; the means by which main-panel gets data
  :name             ;; usage (subscribe [:name])
  (fn  [db _]
    (:display-name db)))

(re-frame/reg-sub        ;; we can check if there is data
  :initialised?          ;; usage (subscribe [:initialised?])
  (fn  [db _]
    (not (empty? db))))  ;; do we have data

(re-frame/reg-event-db
   :initialise-db
   (fn [db _]
       (assoc db :display-name "Jane Doe")))

(defn main-panel    ;; the top level of our app 
  []
  (let [name  (re-frame/subscribe [:name])]   ;; we need there to be good data
    [:div "Hello " @name]))

(defn top-panel    ;; this is new
  []
  (let [ready?  (re-frame/subscribe [:initialised?])]
    (if-not @ready?         ;; do we have good data?
      [:div "Initialising ..."]   ;; tell them we are working on it
      [main-panel])))      ;; all good, render this component

(defn ^:export main     ;; call this to bootstrap your app
  []
  (re-frame/dispatch [:initialise-db])
  (reagent/render [top-panel]
                  (js/document.getElementById "app")))

(main)
