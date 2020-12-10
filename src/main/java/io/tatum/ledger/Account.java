package io.tatum.ledger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import io.tatum.model.request.BlockAmount;
import io.tatum.model.request.CreateAccount;
import io.tatum.model.request.CreateAccountsBatch;
import io.tatum.model.response.ledger.AccountBalance;
import io.tatum.model.response.ledger.Blockage;
import io.tatum.utils.Async;
import io.tatum.utils.Env;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static io.tatum.constants.Constant.TATUM_API_URL;

public class Account {

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/getAccountByAccountId" target="_blank">Tatum API documentation</a>
     */
    public io.tatum.model.response.ledger.Account getAccountById(String id) throws IOException, ExecutionException, InterruptedException {
        String uri = Strings.isNullOrEmpty(Env.getTatumApiUrl()) ? TATUM_API_URL + "/v3/ledger/account" + id : Env.getTatumApiUrl();
        String account = Async.get(uri, Env.getTatumApiKey());
        // TO-DO
        return new io.tatum.model.response.ledger.Account();
    }

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/createAccount" target="_blank">Tatum API documentation</a>
     */
    public io.tatum.model.response.ledger.Account createAccount(CreateAccount account) throws IOException, ExecutionException, InterruptedException {
//        await validateOrReject(account);
//        TO-DO
        String uri = Strings.isNullOrEmpty(Env.getTatumApiKey()) ? TATUM_API_URL + "/v3/ledger/account" : Env.getTatumApiKey();

        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(account);

        String acc = Async.post(uri, Env.getTatumApiKey(), requestBody);
        // TO-DO
        return new io.tatum.model.response.ledger.Account();
    }

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/createAccountBatch" target="_blank">Tatum API documentation</a>
     */
    public io.tatum.model.response.ledger.Account[] createAccounts(CreateAccountsBatch accounts) throws IOException, ExecutionException, InterruptedException {
//        await validateOrReject(accounts);
//        TO-DO
        String uri = Strings.isNullOrEmpty(Env.getTatumApiKey()) ? TATUM_API_URL + "/v3/ledger/account/batch" : Env.getTatumApiKey();

        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(accounts);

        String acc = Async.post(uri, Env.getTatumApiKey(), requestBody);
        // TO-DO
        return new io.tatum.model.response.ledger.Account[]{};
    }

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/getBlockAmount" target="_blank">Tatum API documentation</a>
     */
    public Blockage[] getBlockedAmountsByAccountId(String id, Integer pageSize, Integer offset) throws IOException, ExecutionException, InterruptedException {
        String uri = Strings.isNullOrEmpty(Env.getTatumApiUrl()) ? TATUM_API_URL + "/v3/ledger/account/block/" + id + "?pageSize=" + pageSize + "&offset=" + offset : Env.getTatumApiUrl();
        String tx = Async.get(uri, Env.getTatumApiKey());
        // TO-DO
        return new Blockage[]{};
    }

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/blockAmount" target="_blank">Tatum API documentation</a>
     */
    public String blockAmount(String id, BlockAmount block) throws IOException, ExecutionException, InterruptedException {
//        await validateOrReject(block);
        String uri = Strings.isNullOrEmpty(Env.getTatumApiUrl()) ? TATUM_API_URL + "/v3/ledger/account/block/" + id : Env.getTatumApiUrl();
        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(block);

        String blockId = Async.post(uri, Env.getTatumApiKey(), requestBody);
        return blockId;
    }

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/deleteBlockAmount" target="_blank">Tatum API documentation</a>
     */
    public void deleteBlockedAmount(String id) throws IOException, ExecutionException, InterruptedException {
        String uri = Strings.isNullOrEmpty(Env.getTatumApiUrl()) ? TATUM_API_URL + "/v3/ledger/account/block/" + id : Env.getTatumApiUrl();
        Async.delete(uri, Env.getTatumApiKey());
    }

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/deleteAllBlockAmount" target="_blank">Tatum API documentation</a>
     */
    public void deleteBlockedAmountForAccount(String id) throws IOException, ExecutionException, InterruptedException {
        String uri = Strings.isNullOrEmpty(Env.getTatumApiUrl()) ? TATUM_API_URL + "/v3/ledger/account/block/acoount/" + id : Env.getTatumApiUrl();
        Async.delete(uri, Env.getTatumApiKey());
    }

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/activateAccount" target="_blank">Tatum API documentation</a>
     */
    public void activateAccount(String id) throws IOException, ExecutionException, InterruptedException {
        String uri = Strings.isNullOrEmpty(Env.getTatumApiUrl()) ? TATUM_API_URL + "/v3/ledger/account/" + id + "/activate" : Env.getTatumApiUrl();
        String requestBody = "{}";
        Async.put(uri, Env.getTatumApiKey(), requestBody);
    }

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/deactivateAccount" target="_blank">Tatum API documentation</a>
     */
    public void deactivateAccount(String id) throws IOException, ExecutionException, InterruptedException {
        String uri = Strings.isNullOrEmpty(Env.getTatumApiUrl()) ? TATUM_API_URL + "/v3/ledger/account/" + id + "/deactivate" : Env.getTatumApiUrl();
        String requestBody = "{}";
        Async.put(uri, Env.getTatumApiKey(), requestBody);
    }

    ;

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/freezeAccount" target="_blank">Tatum API documentation</a>
     */
    public void freezeAccount(String id) throws IOException, ExecutionException, InterruptedException {
        String uri = Strings.isNullOrEmpty(Env.getTatumApiUrl()) ? TATUM_API_URL + "/v3/ledger/account/" + id + "/freeze" : Env.getTatumApiUrl();
        String requestBody = "{}";
        Async.put(uri, Env.getTatumApiKey(), requestBody);
    }

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/unfreezeAccount" target="_blank">Tatum API documentation</a>
     */
    public void unfreezeAccount(String id) throws IOException, ExecutionException, InterruptedException {
        String uri = Strings.isNullOrEmpty(Env.getTatumApiUrl()) ? TATUM_API_URL + "/v3/ledger/account/" + id + "/unfreeze" : Env.getTatumApiUrl();
        String requestBody = "{}";
        Async.put(uri, Env.getTatumApiKey(), requestBody);
    }

    ;

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/getAccountsByCustomerId" target="_blank">Tatum API documentation</a>
     */
    public io.tatum.model.response.ledger.Account[] getAccountsByCustomerId(String id, Integer pageSize, Integer offset) throws IOException, ExecutionException, InterruptedException {
        String uri = Strings.isNullOrEmpty(Env.getTatumApiUrl()) ? TATUM_API_URL + "/v3/ledger/account/customer/" + id + "?pageSize=" + pageSize + "&offset=" + offset : Env.getTatumApiUrl();
        String accounts = Async.get(uri, Env.getTatumApiKey());
        // TO-DO
        return new io.tatum.model.response.ledger.Account[]{};
    }

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/getAllAccounts" target="_blank">Tatum API documentation</a>
     */
    public io.tatum.model.response.ledger.Account[] getAllAccounts(Integer pageSize, Integer offset) throws IOException, ExecutionException, InterruptedException {
        String uri = Strings.isNullOrEmpty(Env.getTatumApiUrl()) ? TATUM_API_URL + "/v3/ledger/account?pageSize=" + pageSize + "&offset=" + offset : Env.getTatumApiUrl();
        String accounts = Async.get(uri, Env.getTatumApiKey());
        // TO-DO
        return new io.tatum.model.response.ledger.Account[]{};
    }

    /**
     * For more details, see <a href="https://tatum.io/apidoc#operation/getAccountBalance" target="_blank">Tatum API documentation</a>
     */
    public AccountBalance getAccountBalance(String id) throws IOException, ExecutionException, InterruptedException {
        String uri = Strings.isNullOrEmpty(Env.getTatumApiUrl()) ? TATUM_API_URL + "/v3/ledger/account/" + id + "/balance" : Env.getTatumApiUrl();
        String accounts = Async.get(uri, Env.getTatumApiKey());
        // TO-DO
        return new AccountBalance();
    }

}