(ns mdview.ui
  (:require [seesaw.core :as sw]
            [seesaw.tree :as swt]
            [seesaw.selector :as sws])
  (:import (java.io File)))

(def file-tree-model
  (swt/simple-tree-model
    #(.isDirectory %)
    (fn [f] (.listFiles f))
    (File. ".")))

(def outline-tree-model
  (swt/simple-tree-model
    #(.isDirectory %)
    (fn [f] (.listFiles f))
    (File. ".")))

(def menubar
  (sw/menubar
    :items [(sw/menu :text "文件")
            (sw/menu :text "帮助")
            ]))

(def content
  (sw/border-panel
    :border 5 :hgap 5 :vgap 5
    :north (sw/label :id :cwd :text "当前目录")
    :center
    (sw/left-right-split
      (sw/border-panel
        :north (sw/scrollable (sw/tree :id :file-tree :model file-tree-model ))
        :south (sw/scrollable (sw/tree :id :outline-tree :model outline-tree-model )))
      (sw/editor-pane :id content-pane :content-type "text/html" :editable? false)
      :divider-location 1/3)
    :south (sw/label :id :status :text "状态")))

(def window
  (sw/frame
    :title "Hello"
    :content content
    :width 2000
    :height 1000
    :menubar menubar))

(-> window sw/pack! sw/show!)
