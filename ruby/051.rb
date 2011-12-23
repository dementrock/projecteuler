require 'utils'

LEN = 8

Integer.sieve(1_000_000)

def generate x, lst, digit
  x = x.to_s
  (0...lst.length).each do |i|
    if lst[i] == 1
      x[i] = digit.to_s
    end
  end
  #puts [x, lst, digit].inspect
  x.to_i
end

def search x, lst, cur, same_digit
  if cur == x.to_s.length
    cnt = 0
    start = lst[0]
    (start..9).each do |digit|
      if (generate x, lst, digit).prime?
        cnt += 1
      end
    end
    if cnt == LEN
      puts x
      return true
    else
      return false
    end
  end
  (0..1).each do |choice|
    if choice == 1
      if same_digit
        if x.to_s[cur] != same_digit
          next
        end
      else
        same_digit = x.to_s[cur]
      end
    end
    if search x, lst + [choice], cur + 1, same_digit
      return true
    end
  end
  return false
end


Integer.primes.each do |x|
  if x < 56003
    next
  end
  if search x, [], 0, nil
    break
  end
end

