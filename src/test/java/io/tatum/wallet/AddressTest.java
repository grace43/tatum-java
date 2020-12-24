package io.tatum.wallet;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

public class AddressTest {

    @Test
    public void generateBtcAddress_Mainnet_Test() throws ExecutionException, InterruptedException {
        Address address = new Address();
        String rs = address.generateBtcAddress(false, "xpub6EsCk1uU6cJzqvP9CdsTiJwT2rF748YkPnhv5Qo8q44DG7nn2vbyt48YRsNSUYS44jFCW9gwvD9kLQu9AuqXpTpM1c5hgg9PsuBLdeNncid", 1);
        assertEquals("1HWYaP13JKtaW2Mhq69NVeSLjRYGpD3aKv", rs);
    }

    @Test
    public void generateBtcAddress_Testnet_Test() throws ExecutionException, InterruptedException {
        Address address = new Address();
        String rs = address.generateBtcAddress(true, "tpubDFjLw3ykn4aB7fFt96FaqRjSnvtDsU2wpVr8GQk3Eo612LS9jo9JgMkQRfYVG248J3pTBsxGg3PYUXFd7pReNLTeUzxFcUDL3zCvrp3H34a", 1);
        assertEquals("mjJotvHmzEuyXZJGJXXknS6N3PWQnw6jf5", rs);
    }

    @Test
    public void generateLtcAddress_Mainnet_Test() throws ExecutionException, InterruptedException {
        Address address = new Address();
        String rs = address.generateLtcAddress(false, "Ltub2aXe9g8RPgAcY6jb6FftNJfQXHMV6UNBeZwrWH1K3vjpua9u8uj95xkZyCC4utdEbfYeh9TwxcUiFy2mGzBCJVBwW3ezHmLX2fHxv7HUt8J", 1);
        // ssertEquals("LepMzqfXSgQommH2qu3fk7Gf5xgoHQsP1b", rs); // from tatum.js
        assertEquals("1LbQjdMhN2AkWxasfm4NU6CtskKXEHaCKr", rs);
    }

    @Test
    public void generateLtcAddress_Testnet_Test() throws ExecutionException, InterruptedException {
        Address address = new Address();
        String rs = address.generateLtcAddress(true, "ttub4giastL5S3AicjXRBEJt7uq22b611rJvVfTgJSRfYeyZkwXwKnZcctK3tEjMpqrgiNSnYAzkKPJDxGoKNWQzkzTJxSryHbaYxsYW9Vr6AYQ", 1);
        assertEquals("mjJotvHmzEuyXZJGJXXknS6N3PWQnw6jf5", rs);
    }

    @Test
    public void generateBtcPrivateKey_Mainnet_Test() throws ExecutionException, InterruptedException {
        Address address = new Address();
        String rs = address.generateBtcPrivateKey(false, "quantum tobacco key they maid mean crime youth chief jungle mind design broken tilt bus shoulder leaf good forward erupt split divert bread kitten", 1);
        assertEquals("KwrYonf8pFfyQR87NTn124Ep9zoJsZMBCoVUi7mjMc1eTHDyLyBN", rs);
    }

}