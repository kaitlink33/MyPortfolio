# Name: Kaitlin Kendig
# Section: CIS116 F25 (16232)
# Project: Vending Machine
# Description: a Finite State Machine that 
# represents a diet vending machine. 
# The vending machine dispenses three different 
# types of food.

state= "A"
total_inserted= 0
cost= 1.5
item_1= 2
item_2= 4
item_3= 6
amount_to_return=0
coins_inserted=0

while True:
    
    
    #main point of decision, welcome, and status
    if state== "A":
        print("="*40)
        print("Welcome to the Diet Vending Machine!")
        print ("="*40)
        print(f"{total_inserted:,.2f} inserted. Each item costs ${cost:,.2f}.")
        user_input= input("Type 'q' to quit, 's' to restock, or anything else to continue:")
        if user_input == 'q':
             state = "G"
        elif user_input == 's':
             state = "F"
        else:
             state = "B"
    
    
    #insert coins
    elif state == "B":
        amount_inserted= input("Please insert money (.05, .1, .25, or 1) or 'r' for refund:")
          #The insertion is implied to be always coins in the assignment details; I'm assuming this machine only takes coins
        if amount_inserted == "0.5" or ".1" or ".25" or "1":
            coins_inserted +=1
        if amount_inserted=='r':
            state = "E"
        elif amount_inserted != '.05' and amount_inserted != '.1' and amount_inserted != '.25' and amount_inserted != '1':
            print("Bad input, try again.")
            state = "B"
        else:
            amount_inserted= float(amount_inserted)
            total_inserted += amount_inserted
            if total_inserted >= cost:
                state = "C"
            else:
                print(f"You need more funds to purchase an item that costs ${cost:,.2f}. Keep inserting money.")
                # I go to A here because I want to give the chance to escape if necessary
                state = "A"        
    
    
    #selection of items
    elif state == "C":
        item_selected= input("Please select a snack (1, 2, or 3) or 'r' for refund:")
        if item_selected == 'r':
            state = "E"
        elif item_selected != '1' and item_selected != '2' and item_selected != '3':
            print("Bad input, try again.")
            state = "C"
        else: 
            state = "D"
    
    
    #dispensing, (ensures stock) with a bonus item if coins inserted is even and stock allow
    elif state == "D":
        if item_selected == '1':
            if coins_inserted % 2 == 0 and item_1>= 2:
                item_1 -= 2
            elif item_1 > 0:
                item_1 -= 1
            else:
                print("Item 1 is out of stock, please make another selection.")
                state = "C"
        elif item_selected == '2':
            if coins_inserted % 2 == 0 and item_2 >=2:
                item_2 -= 2
            elif item_2 > 0:
                item_2 -= 1
            else:
                print("Item 2 is out of stock, please make another selection.")
                state = "C" 
        else:
            if coins_inserted % 2 == 0 and item_3 >=2:
                item_3 -= 2
            elif item_3 > 0:
                item_3 -= 1
            else:
                print("Item 3 is out of stock, please make another selection.")
                state = "C"   
        print("Dispensing Food...")
        total_inserted -= cost
        amount_to_return = total_inserted
        state = "E"
        #gives a funky discount, but it was in the rubric so I included it - a feature, not a bug!
    
    
    #return change
    elif state == "E":
        print(f"Returning change... {total_inserted:,.2f}")
        total_inserted=0
        state = "A"
    
    
    #restock
    elif state == "F":
        item_1= 2
        item_2= 4
        item_3= 6
        print("Restocking the machine...")
        state = "A"

    
    #poweroff
    elif state == "G":
        print("Shutting down the machine...")
        break