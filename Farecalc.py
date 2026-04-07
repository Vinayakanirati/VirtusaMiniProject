
def farecalc (km,hour,vehicle):
    services={"car":10,"bus":5,"bike":2,"SUV":20}
    try:
        if vehicle not in services.keys():
            raise ValueError(f"The service {vehicle} is not available")
        if hour in range(17,21):
            surge=1.5
        else:
            surge=1
        fare = services[vehicle] * km 
        return """PRICE RECIEPT 
        VEHICLE: {vehicle}  KM: {km} 
        SERVICE CHARGE FOR {vehicle}: {charge}
        SURGE: {surge}
        TOTAL FARE: {cost:.2f}""".format(vehicle=vehicle, km=km,charge=services[vehicle], surge=surge, fare=fare,cost=fare*surge)
    except ValueError as e:
        print(e)
        return None
print("welcome to city cab services ")
try:
    km = float(input("Enter distance to be travelled in KM: "))
    hour = int(input("Enter the hour of the day (0-23): "))
    vehicle = input("Enter the type of vehicle (car, bus, bike, SUV): ")
    if km < 0:  
        raise ValueError("The distance must be greater than 0")
    if hour < 0 or hour > 23:
        raise ValueError("The hour must be between 0 and 23")
    fare = farecalc(km, hour, vehicle)
    if fare:  
        print(fare)
except ValueError as e:
    print(e)