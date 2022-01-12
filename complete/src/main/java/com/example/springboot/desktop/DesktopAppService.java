package com.example.springboot.desktop;

import com.example.springboot.helpers.DBHelper;
import com.example.springboot.user.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Dictionary;
import java.util.Hashtable;

@Service
public class DesktopAppService {

    private Dictionary<Integer, DesktopApp> desktopList= new Hashtable<Integer, DesktopApp>();
    private int deviceId = 0;

    public String RegisterDesktop(User user) throws GeneralSecurityException, IOException {
        //create a deviceId
        //is received a public (and private key?) or generated

        DesktopApp desktop = new DesktopApp(deviceId++);
        //DBHelper.AddDeviceToDB(device, desktop);
        desktopList.put(deviceId, desktop);

        return "olá!";
    }
}