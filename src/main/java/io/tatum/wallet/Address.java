package io.tatum.wallet;

import io.tatum.model.request.Currency;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.crypto.ChildNumber;
import org.bitcoinj.crypto.HDUtils;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static io.tatum.constants.Constant.*;

public class Address {

    /**
     * Generate Bitcoin address
     *
     * @param testnet testnet or mainnet version of address
     * @param xpub    extended public key to generate address from
     * @param i       derivation index of address to generate. Up to 2^32 addresses can be generated.
     * @returns blockchain address
     */
    public String generateBtcAddress(Boolean testnet, String xpub, int i) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            NetworkParameters network = testnet ? BITCOIN_TESTNET : BITCOIN_MAINNET;
            ChildNumber path = new ChildNumber(i, false);
            return AddressBuilder.build().network(network).fromBase58(xpub).derivePath(path).toBase58();
        }).get();
    }

    /**
     * Generate Bitcoin address
     *
     * @param testnet testnet or mainnet version of address
     * @param xpub    extended public key to generate address from
     * @param i       derivation index of address to generate. Up to 2^32 addresses can be generated.
     * @returns blockchain address
     */
    public String generateLtcAddress(Boolean testnet, String xpub, int i) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            NetworkParameters network = testnet ? LITECOIN_TESTNET : LITECOIN_MAINNET;
            ChildNumber path = new ChildNumber(i, false);
            return AddressBuilder.build().network(network).fromBase58(xpub).derivePath(path).toBase58();
        }).get();
    }

    /**
     * Generate Bitcoin Cash address
     *
     * @param testnet testnet or mainnet version of address
     * @param xpub    extended public key to generate address from
     * @param i       derivation index of address to generate. Up to 2^32 addresses can be generated.
     * @returns blockchain address
     */
    public String generateBchAddress(Boolean testnet, String xpub, int i) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            NetworkParameters network = testnet ? BITCOIN_TESTNET : BITCOIN_MAINNET;
            ChildNumber path = new ChildNumber(i, false);
            return AddressBuilder.build().network(network).fromBase58(xpub).derivePath(path).toCashAddress();
        }).get();
    }

    /**
     * Generate Ethereum or any other ERC20 address
     *
     * @param testnet testnet or mainnet version of address
     * @param xpub    extended public key to generate address from
     * @param i       derivation index of address to generate. Up to 2^32 addresses can be generated.
     * @returns blockchain address
     */
    public String generateEthAddress(Boolean testnet, String xpub, int i) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            ChildNumber path = new ChildNumber(i, false);
            NetworkParameters network = BITCOIN_MAINNET;
            return "0x" + AddressBuilder.build().network(network).fromBase58(xpub).derivePath(path).toEtherAddress();
        }).get();
    }

    /**
     * Generate VeChain address
     *
     * @param testnet testnet or mainnet version of address
     * @param xpub    extended public key to generate address from
     * @param i       derivation index of address to generate. Up to 2^32 addresses can be generated.
     * @returns blockchain address
     */
    public String generateVetAddress(Boolean testnet, String xpub, int i) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            ChildNumber path = new ChildNumber(i, false);
            NetworkParameters network = BITCOIN_MAINNET;
            return "0x" + AddressBuilder.build().network(network).fromBase58(xpub).derivePath(path).toEtherAddress();
        }).get();
    }

    /**
     * Generate Bitcoin private key from mnemonic seed
     *
     * @param testnet  testnet or mainnet version of address
     * @param mnemonic mnemonic to generate private key from
     * @param i        derivation index of private key to generate.
     * @returns blockchain private key to the address
     */
    public String generateBtcPrivateKey(Boolean testnet, String mnemonic, int i) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            NetworkParameters network = testnet ? BITCOIN_TESTNET : BITCOIN_MAINNET;
            List<ChildNumber> path = testnet ? HDUtils.parsePath(TESTNET_DERIVATION_PATH) : HDUtils.parsePath(BTC_DERIVATION_PATH);
            return PrivateKeyBuilder.build()
                    .network(network)
                    .fromSeed(mnemonic)
                    .derivePath(path)
                    .derive(i)
                    .toWIF();
        }).get();
    }

    /**
     * Generate Litecoin private key from mnemonic seed
     *
     * @param testnet  testnet or mainnet version of address
     * @param mnemonic mnemonic to generate private key from
     * @param i        derivation index of private key to generate.
     * @returns blockchain private key to the address
     */
    public String generateLtcPrivateKey(Boolean testnet, String mnemonic, int i) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            NetworkParameters network = testnet ? LITECOIN_TESTNET : LITECOIN_MAINNET;
            List<ChildNumber> path = testnet ? HDUtils.parsePath(TESTNET_DERIVATION_PATH) : HDUtils.parsePath(LTC_DERIVATION_PATH);
            return PrivateKeyBuilder.build()
                    .network(network)
                    .fromSeed(mnemonic)
                    .derivePath(path)
                    .derive(i)
                    .toWIF();
        }).get();
    }

    /**
     * Generate Bitcoin Cash private key from mnemonic seed
     *
     * @param testnet  testnet or mainnet version of address
     * @param mnemonic mnemonic to generate private key from
     * @param i        derivation index of private key to generate.
     * @returns blockchain private key to the address
     */
    public String generateBchPrivateKey(Boolean testnet, String mnemonic, int i) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            NetworkParameters network = testnet ? BITCOIN_TESTNET : BITCOIN_MAINNET;
            List<ChildNumber> path = HDUtils.parsePath(BCH_DERIVATION_PATH);
            return PrivateKeyBuilder.build()
                    .network(network)
                    .fromSeed(mnemonic)
                    .derivePath(path)
                    .derive(i)
                    .toWIF();
        }).get();
    }

    /**
     * Generate Ethereum or any other ERC20 private key from mnemonic seed
     *
     * @param testnet  testnet or mainnet version of address
     * @param mnemonic mnemonic to generate private key from
     * @param i        derivation index of private key to generate.
     * @returns blockchain private key to the address
     */
    public String generateEthPrivateKey(Boolean testnet, String mnemonic, int i) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            List<ChildNumber> path = testnet ? HDUtils.parsePath(TESTNET_DERIVATION_PATH) : HDUtils.parsePath(ETH_DERIVATION_PATH);
            return "0x" + PrivateKeyBuilder.build()
                    .fromSeed(mnemonic)
                    .derivePath(path)
                    .derive(i)
                    .toHex();
        }).get();
    }

    /**
     * Generate Ethereum or any other ERC20 private key from mnemonic seed
     *
     * @param testnet  testnet or mainnet version of address
     * @param mnemonic mnemonic to generate private key from
     * @param i        derivation index of private key to generate.
     * @returns blockchain private key to the address
     */
    public String generateVetPrivateKey(Boolean testnet, String mnemonic, int i) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            List<ChildNumber> path = testnet ? HDUtils.parsePath(TESTNET_DERIVATION_PATH) : HDUtils.parsePath(VET_DERIVATION_PATH);
            return "0x" + PrivateKeyBuilder.build()
                    .fromSeed(mnemonic)
                    .derivePath(path)
                    .derive(i)
                    .toHex();
        }).get();
    }

    /**
     * Generate Cardano private key from mnemonic seed
     *
     * @param testnet  testnet or mainnet version of address
     * @param mnemonic mnemonic to generate private key from
     * @param i        derivation index of private key to generate.
     * @returns blockchain private key to the address
     */
    public String generateAdaPrivateKey(Boolean testnet, String mnemonic, int i) throws ExecutionException, InterruptedException {
        return CompletableFuture.supplyAsync(() -> {
            List<ChildNumber> path = HDUtils.parsePath(ADA_DERIVATION_PATH);
            return PrivateKeyBuilder.build()
                    .fromSeed(mnemonic)
                    .derivePath(path)
                    .derive(i)
                    .toHex();
        }).get();
    }

    /**
     * Generate address
     *
     * @param currency type of blockchain
     * @param testnet  testnet or mainnet version of address
     * @param xpub     extended public key to generate address from
     * @param i        derivation index of address to generate. Up to 2^32 addresses can be generated.
     * @returns blockchain address
     */
    public String generateAddressFromXPub(Currency currency, boolean testnet, String xpub, int i) throws Exception {
        switch (currency) {
            case BTC:
                return generateBtcAddress(testnet, xpub, i);
//            case Currency.ADA:
//                return generateAdaAddress(testnet, xpub, i);
            case LTC:
                return generateLtcAddress(testnet, xpub, i);
            case BCH:
                return generateBchAddress(testnet, xpub, i);
            case USDT:
            case LEO:
            case LINK:
            case UNI:
            case FREE:
            case MKR:
            case USDC:
            case BAT:
            case TUSD:
            case PAX:
            case PAXG:
            case PLTC:
            case XCON:
            case ETH:
            case MMY:
                return generateEthAddress(testnet, xpub, i);
            case VET:
                return generateVetAddress(testnet, xpub, i);
            default:
                throw new Exception("Unsupported blockchain.");
        }
    }

    /**
     * Generate private key from mnemonic seed
     *
     * @param currency type of blockchain
     * @param testnet  testnet or mainnet version of address
     * @param mnemonic mnemonic to generate private key from
     * @param i        derivation index of private key to generate.
     * @returns blockchain private key to the address
     */
    public String generatePrivateKeyFromMnemonic(Currency currency, Boolean testnet, String mnemonic, int i) throws Exception {
        switch (currency) {
            case BTC:
                return generateBtcPrivateKey(testnet, mnemonic, i);
            case ADA:
                return generateAdaPrivateKey(testnet, mnemonic, i);
            case LTC:
                return generateLtcPrivateKey(testnet, mnemonic, i);
            case BCH:
                return generateBchPrivateKey(testnet, mnemonic, i);
            case USDT:
            case LEO:
            case LINK:
            case UNI:
            case FREE:
            case MKR:
            case USDC:
            case BAT:
            case TUSD:
            case PAX:
            case PAXG:
            case PLTC:
            case XCON:
            case ETH:
            case MMY:
                return generateEthPrivateKey(testnet, mnemonic, i);
            case VET:
                return generateVetPrivateKey(testnet, mnemonic, i);
            default:
                throw new Exception("Unsupported blockchain.");
        }
    }
}
