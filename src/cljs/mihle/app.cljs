(ns mihle.app
  (:require [reagent.core :as reagent :refer [atom]]))

(def toys
  [{:name "Spinning Top" :color "Red" :image-url "https://upload.wikimedia.org/wikipedia/commons/9/90/A_tough_gang_of_Spinning_Tops.jpg"}
   {:name "iPad" :color "Black"}])

(defn toy-view [toy]
  [:div.media
   [:div.media-left.media-middle
    [:a {:href "#"}
     [:img.media-object
      {:src (:image-url toy)
       :width "200"}]]]
   [:div.media-body
    [:h4.media-heading
     (:name toy)]
    [:p "Color: " (:color toy)]]])

(defn calling-component []
  [:div.container
   [:div.row
    [:div.col-md-3
     [:h1.text-center "Mihle"]
     [:img.img-responsive.img-circle
      {:src "images/mihle-glasses.jpg"}]]
    [:div.col-md-9
     [:h1 "Mihle's Toys"]
     (for [t toys]
       [toy-view t])]]])

(defn init []
  (reagent/render-component [calling-component]
                            (.getElementById js/document "container")))
