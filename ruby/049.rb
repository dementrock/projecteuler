require 'utils'

Integer.sieve(10000)

def perm_lst x
  x.to_s.each_char.to_a.collect {|x| x.to_i}.sort
end

(1000..9999).each do |x|
  if x.prime?
    (x+1..9999).each do |y|
      if y.prime?
        if perm_lst(x) == perm_lst(y)
          z = y + y - x
          if z.prime? and perm_lst(z) == perm_lst(y)
            puts [x, y, z].inspect
          end
        end
      end
    end
  end
end
