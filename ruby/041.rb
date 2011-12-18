require 'utils'
require 'set'


puts Comb.perm(Array(1..7)).collect { |x| x.to_s.to_i }.select{ |x| x.prime? }.max
