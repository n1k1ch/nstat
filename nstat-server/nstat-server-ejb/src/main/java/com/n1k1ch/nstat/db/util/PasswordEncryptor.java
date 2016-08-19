package com.n1k1ch.nstat.db.util;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by ncherevkov on 8/19/2016.
 */
@Stateless
@LocalBean
public class PasswordEncryptor {

    public String encrypt(String source) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance( "SHA-256" );
        md.update( source.getBytes() );
        byte[] aMessageDigest = md.digest();

        return Base64.getEncoder().encodeToString( aMessageDigest );
    }
}
