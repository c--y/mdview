(ns mdview.markdown
  (:require [net.cgrand.enlive-html :as eh]
            [markdown.core :as md])
  (:import (java.net URL)))

(defn fetch-page [url]
  (eh/html-resource (URL. url)))

(defn parse-string [text]
  (eh/html-content text))

(defn find-headings [obj]
  (eh/select
    obj
    #{[:h1] [:h2] [:h3]}))

(defn render-markdown [text]
  (md/md-to-html-string text :heading-anchors true))
