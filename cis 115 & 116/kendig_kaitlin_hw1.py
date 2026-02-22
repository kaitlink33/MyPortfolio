# %%
"""
File Name: kendig_kate_hw1.py
Author: Kate (Kaitlin) Kendig
Section: Dog Age Calculator- HW1 CIS 116
Description: calculates the dog’s current age in human years (and cat years) based on the dog's current age & size
"""

#Intro and gather information
print("="*35 + "\n Welcome to the Dog Age Calculator!\n"+"="*35)
dog_name=input("What is the name of your dog? ")
dog_size=input("How big is your dog? \n (format: s for small, m for medium, or l for large) ")
dog_birth_year=int(input("What year was your dog born? "))
current_year=int(input("What is the current year? "))
years_lived = current_year - dog_birth_year

#from real years live to dog's age in human years calculations
if years_lived <= 2:
    human_age = years_lived * 10.5
else: 
    human_age = ((2 * 10.5) + ((years_lived - 2) * 4))

#from real years lived to dog's age in cat years calculation
if years_lived == 1:
    cat_years = 15
elif years_lived == 2: 
    cat_years = 24
else:
    cat_years = (24 + ((years_lived - 2) * 4))

#return calculations
print("=" * 35)
print(f"If {dog_name} was 2 human years old, that's 21 dog years.")
print(f"If {dog_name} was 4 human years old, that's 29 dog years.")
print(f"If {dog_name} was 6 human years old, that's 37 dog years.")
print(f"If {dog_name} was a cat, it would be {cat_years:,.0f} cat years old!")
print(f"Now, {dog_name} is {human_age:,.0f} years old in dog years!")
print("=" * 35)

#compare to user age and return
print("Let's compare your dog's age to your age!")
user_age = float(input("What is your age (in years)? "))
difference = (user_age - human_age)
if difference > 0:
    print(f"You are older than {dog_name} by {difference:,.0f} years!")
elif difference < 0:
        print(f"{dog_name} is older than you by {(difference * -1):,.0f} years! Wow!")
else:
        print(f"You and {dog_name} are the same age! What are the odds?")







# %%


# %%


# %%




