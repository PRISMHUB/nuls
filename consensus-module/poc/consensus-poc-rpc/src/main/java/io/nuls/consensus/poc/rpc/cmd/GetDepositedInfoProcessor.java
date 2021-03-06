/*
 * MIT License
 *
 * Copyright (c) 2017-2018 nuls.io
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package io.nuls.consensus.poc.rpc.cmd;

import io.nuls.kernel.model.RpcClientResult;
import io.nuls.kernel.utils.CommandBuilder;
import io.nuls.kernel.utils.CommandHelper;
import io.nuls.core.tools.str.StringUtils;
import io.nuls.kernel.model.CommandResult;
import io.nuls.kernel.processor.CommandProcessor;
import io.nuls.kernel.utils.RestFulUtils;
import java.util.Map;

/**
 * 根据账户地址获取该账户参与的所有委托(共识)信息的总览
 * According to the account address to obtain all information on the deposit of the account
 * @author: Charlie
 */
public class GetDepositedInfoProcessor implements CommandProcessor {

    private RestFulUtils restFul = RestFulUtils.getInstance();

    @Override
    public String getCommand() {
        return "getdepositedinfo";
    }

    @Override
    public String getHelp() {
        CommandBuilder bulider = new CommandBuilder();
        bulider.newLine(getCommandDescription())
                .newLine("\t<address> address of the account - Required");
        return bulider.toString();
    }

    @Override
    public String getCommandDescription() {
        return "getdepositedinfo <address>  --according to the account address to obtain overview on the deposited of the account";
    }

    @Override
    public boolean argsValidate(String[] args) {
        int length = args.length;
        if(length != 2){
            return false;
        }
        if (!CommandHelper.checkArgsIsNull(args)) {
            return false;
        }
        if(!StringUtils.validAddressSimple(args[1])){
            return false;
        }
        return true;
    }

    @Override
    public CommandResult execute(String[] args) {
        String address = args[1];
        RpcClientResult result = restFul.get("/consensus/address/" + address, null);
        if (result.isFailed()) {
            return CommandResult.getFailed(result);
        }
        Map<String, Object> map = (Map)result.getData();
        map.put("usableBalance",  CommandHelper.naToNuls(map.get("usableBalance")));
        map.put("totalDeposit", CommandHelper.naToNuls(map.get("totalDeposit")));
        map.put("reward", CommandHelper.naToNuls(map.get("reward")));
        map.put("rewardOfDay", CommandHelper.naToNuls(map.get("rewardOfDay")));
        result.setData(map);
        return CommandResult.getResult(result);
    }
}
