require 'hpricot'
require 'open-uri'

def hpricot(account = "while42")
  file = open("http://twitter.com/#{account}")
  Hpricot(file)
end

def tweets(doc)
  items = doc / ".stream-item"
  items.each do |item|
    tweet = item / ".tweet .js-tweet-text"
    puts tweet.inner_text
    puts "_____________\n\n"
  end
end

doc = hpricot("while42")
tweets(doc)
