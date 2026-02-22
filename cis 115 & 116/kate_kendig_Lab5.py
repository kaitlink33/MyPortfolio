#kate_kendig_Lab5
print("---- Getting User Input ----")
printable=input("Enter the character you would like: ")
width= int(input("Enter how wide you would like the triangle to be: "))

#problem1
print("----- First Part -----")
i=0
while i <= width:
    space_amount = width - i
    a = 0 
    while a < space_amount:
        print(" ", end="")
        a+=1
    i += 1
    print(printable * (width - space_amount))
    print("\n")

#problem2
print("----- Second Part -----")
width_problem_2 = width - 1
b=0
space_amount_2= 1
while 0 < width_problem_2:
    j=0
    
    while j < space_amount_2:
        print(" ", end = "")
        j+=1
    k = 0
    while k < width_problem_2:
        print(printable, end = "")
        k+= 1
    space_amount_2 += 1
    width_problem_2 -= 1
    print("\n")

#problem3
print("----- Third Part -----")
x=0
while x == 0:
    i=0
    while i <= width:
        space_amount = width - i
        a = 0 
        while a < space_amount:
            print(" ", end="")
            a+=1
        i += 1
        print(printable * (width - space_amount))
        print("\n")

    width_problem_2 = width - 1
    b=0
    space_amount_2= 1
    #solution problem 2, one outer while loop
    while 0 < width_problem_2:
        j=0
    
        while j < space_amount_2:
            print(" ", end = "")
            j+=1
        k = 0
        while k < width_problem_2:
            print(printable, end = "")
            k+= 1
        space_amount_2 += 1
        width_problem_2 -= 1
        print("\n")
    x+=1    

