(ns ^:figwheel-always app.core
    (:require [rum.core :as rum]))

(enable-console-print!)

(defonce state 
  (atom {:headline "Hello World!"
         :content "Lorem ipsum dolor sit amet, consectetur adipiscing elit."}))

(rum/defc article < rum/cursored [state]
  (let [{:keys [:headline :content]} @state] 
    [:section
     [:h1 headline]
     [:p content]]))

(defn render!
  ([] (render! state))
  ([state]
   (rum/mount 
     (article state)
     (.getElementById js/document "app"))))

(render!)

(add-watch state :re-render (fn [_ _ _ _] (render!)))

#_(swap! state assoc :headline "Goodbye World!")
#_(swap! state assoc :content "Vivamus fermentum semper porta.")

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

