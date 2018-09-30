import numpy as np
import pylab as pl
import math

def changeFig(s, x, y):
	pl.figure(s)
	pl.title(s)
	pl.xlabel(x)
	pl.ylabel(y)

weights=[1, 1.2, 1.3, 1.5, 1.7, 1.8, 2.0, 3.0]
weights=[w+0.036 for w in weights]
weights=[w*9.8 for w in weights]
vol_ml=[5.1,4.7,4.6,4.3,4.1,4,3.8,3.1]

pressure=[(w/2E-4)+1.01E5 for w in weights]
#inv_pressure=[1/p for p in pressure]
vol_m=[v*1E-6 for v in vol_ml]
inv_vol=[1/v for v in vol_m]
lin_inv_v=np.polyfit(inv_vol,pressure,1)
k=[p*v for p,v in zip(pressure,vol_m)]
n=1.225*7E-6*1E3/28.97
nRT=1.225*7E-6*1E3/28.97*8.31*294
print(*lin_inv_v)
print(n)
print(nRT)
print((lin_inv_v[0]-nRT)/nRT*100)

changeFig("Pressure vs. Volume", "Volume(mL)", "Pressure(Pa)")
pl.plot(vol_ml,pressure)
pl.plot(vol_ml,pressure,"ko")
pl.plot(7,1.01E5+0.036,"k^")
changeFig("Pressure vs. Inverse Volume", "Inverse Volume(1/m^3)", "Pressure(Pa)")
pl.plot(inv_vol, pressure, "m", label="Experimental Data")
pl.plot(inv_vol, pressure, "ko")
pl.plot(inv_vol, np.poly1d(lin_inv_v)(inv_vol), "g", label="Line of Best Fit")
pl.legend()
#pl.show()

#print(*pressure)
#print(*vol_m)