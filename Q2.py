import json
import hashlib
import sys
import time
import matplotlib.pyplot as plt
import psutil
import os

##########   read input file and close it   ##################

try:
    start_time = time.time()
    input_text = ""
    output = ""
    usersArray= []
    usersDict = {}
    with open("j.json", "r") as my_input:
        input_text= json.load(my_input)
    for dict in input_text:
        usersArray.append(dict["username"] + ":" + str(hash(str((dict["password"])))))
    usersDict["users"] = usersArray
    print (json.dumps(usersDict))

    try:
        with open ("users.txt", "w") as output_file:
            output_file.write(json.dumps(usersDict))

    except IOError:
        print ('cannot open ', output_file, " for writing")


except IOError or ValueError:
    print ('cannot open ', my_input, " for reading")
    print(sys.exc_info()[0])
    exit(1)

#print("Time: --- %s ms ---" % ((time.time() - start_time) * 1000))
v_memory = psutil.virtual_memory()
#display in KB format
used = v_memory.used / 1024**2

print ("virtual memory = " + str(used) + "MB")


#plt.plot([1,2,3,4])
#plt.ylabel('some numbers')
#plt.show()











#import numpy as np
#import matplotlib.pyplot as plt


# the histogram of the data
#n, bins, patches = plt.hist([5,5,7,10], 50, normed=1, facecolor='g', alpha=0.75)


#plt.xlabel('runtime (ms)')
#plt.ylabel('Probability')
#plt.title('Histogram of IQ')
#plt.text(60, .025, r'$\mu=100,\ \sigma=15$')
#plt.axis([0, 160, 0, 0.03])
#plt.grid(True)
#plt.show()