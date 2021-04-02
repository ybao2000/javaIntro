# G. Years
n = int(input())
years = []
for i in range(n):
  vals = input().split()
  years.append((int(vals[0]), 1)) # tuple of birth
  years.append((int(vals[1]), -1))  # tuple of death
# then we need to sort it
# the trick here is sort the year value first, then year type second
years.sort()
max_population = 0
population = 0
for year in years:
  if year[1] == -1:
    population -= 1
  else:
    population += 1
    if population > max_population:
      max_population = population
      max_year = year[0]

print(max_year, max_population)
