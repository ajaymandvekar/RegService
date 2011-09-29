package com.design;
import java.rmi.RemoteException;
import com.design.RegisterClassStub.Registration;
import com.design.RegisterClassStub.RegistrationResponse;

public class TestClientReg {
	public static void main(String[] args) throws RemoteException {
		RegisterClassStub stub = new RegisterClassStub();
		Registration reg = new Registration();
		reg.setFname("Ajay");
		reg.setLname("Mandvekar");
		reg.setEmail("ajaymandvekar@gmail.com");
		RegistrationResponse resp = stub.registration(reg);
		System.out.println(resp.get_return());
	}
}
