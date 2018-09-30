#zois don't worry I'm using matplotlib for physics
import pylab as pl
from scipy.optimize import curve_fit
from numpy import linspace
def changeFig(s, x, y):
	pl.figure(s)
	pl.title(s)
	pl.xlabel(x)
	pl.ylabel(y)
def lens_eq(x,f):
	return (x*f)/(x-f)
#datasets
obj_L=[13,20,30,39,44,50,60,70,80,90,100]
img_L=[51,21.3,15,14,13.375,13,12.25,12.15,11.8,11.55,11.4]
obj_4=[20,30,39,44,50,60,70,80,90,100]
img_4=[21.1,15.5,13.8,13.2,12.8,12.4,12.1,11.9,11.7,11.45]

domain_L=linspace(13,100,50)
domain_4=linspace(20,100,50)

est_fL = curve_fit(lens_eq, obj_L, img_L)[0][0]
est_f4 = curve_fit(lens_eq, obj_4, img_4)[0][0]
#print(est_f)

def graph():
	changeFig("(Object: L) Image Distance (cm) vs. Object Distance (cm)","Object Distance (cm)","Image Distance (cm)")
	pl.plot(obj_L,img_L, "ko", label="Data")
	pl.axvline(x=est_fL, color="m", linestyle="--", label="Estimated focal length (est_fL) = %.3f cm"%(est_fL))
	pl.axhline(y=est_fL, color="m", linestyle="--")
	pl.plot(domain_L, [lens_eq(x, est_fL) for x in domain_L], "b", label=" pred. d_img = d_obj*est_fL/(d_obj-est_fL)")
	pl.ylim([0,60])
	pl.legend()


	changeFig("(Object: 4) Image Distance (cm) vs. Object Distance (cm)","Object Distance (cm)","Image Distance (cm)")
	pl.plot(obj_4,img_4, "ko", label="Data")
	pl.axvline(x=est_f4, color="m", linestyle="--", label="Estimated focal length (est_f4) = %.3f cm"%(est_f4))
	pl.axhline(y=est_f4, color="m", linestyle="--")
	pl.plot(domain_4, [lens_eq(x, est_f4) for x in domain_4], "b", label=" pred. d_img = d_obj*est_f4/(d_obj-est_f4)")
	pl.ylim([0,60])
	pl.legend()

	pl.show()

graph()