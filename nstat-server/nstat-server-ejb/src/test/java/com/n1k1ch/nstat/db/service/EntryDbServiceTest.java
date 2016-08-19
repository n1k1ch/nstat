package com.n1k1ch.nstat.db.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.security.MessageDigest;
import java.util.Base64;


/**
 * Created by ncherevkov on 7/8/2016.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class EntryDbServiceTest {

	@Test
	public void testFindAll() throws Exception {
		String test = "n1k1chz";
		MessageDigest md = MessageDigest.getInstance( "SHA-256" );
		md.update( test.getBytes() );
		byte[] aMessageDigest = md.digest();

		String outEncoded = Base64.getEncoder().encodeToString( aMessageDigest );
		System.out.println(outEncoded);
		System.out.println(outEncoded);
	}
}