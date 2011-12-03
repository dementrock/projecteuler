require 'linguistics'
Linguistics::use :en
puts (1..1000).collect {|x| x.en.numwords.delete('/[ ,-]/').length}.inject(:+)
