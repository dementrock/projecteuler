"""
All primitive solution to x^2 + y^2 = z^2 with y even has the form
x = r^2 - s^2, y = 2rs, z = r^2 + s^2
So x + y + z = L = 2r^2 + 2rs = 2r(r+s)
L / 2 = r * (r + s)
when s = 1: r * (r + 1) = L / 2
l >= r^2
"""

MAX = 1_500_000

def check l
  l = l / 2
  ((Math.sqrt(l/2).floor)..(Math.sqrt(l).floor)).each do |r|
    if l % r == 0
      s = l / r - r
      if r > s
        puts [r, s,r*r-s*s, 2*r*s, r*r+s*s].inspect
      end
    end
  end
end

check(30)

"""(1..MAX).each do |x|
  if check(x)
    puts x
  end
end"""
