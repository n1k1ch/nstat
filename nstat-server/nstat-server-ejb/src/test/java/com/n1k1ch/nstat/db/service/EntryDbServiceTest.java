package com.n1k1ch.nstat.db.service;

import org.junit.Test;

import java.security.MessageDigest;
import java.util.Base64;

import static org.junit.Assert.*;

/**
 * Created by ncherevkov on 7/8/2016.
 */
public class EntryDbServiceTest {

	@Test
	public void testFindAll() throws Exception {
		String test = "test";
		MessageDigest md = MessageDigest.getInstance( "SHA-256" );
		md.update( test.getBytes() );
		byte[] aMessageDigest = md.digest();

		String outEncoded = Base64.getEncoder().encodeToString( aMessageDigest );
		System.out.println(outEncoded);
	}
}