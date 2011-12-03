require 'date'
puts (Date.new(1901, 1, 1) .. Date.new(2000, 12, 31)).select {|day| day.wday == 0 and day.mday == 1}.length
