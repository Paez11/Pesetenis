package iesfranciscodelosrios.pesetenis.utils;

import iesfranciscodelosrios.pesetenis.model.dataobject.Account;
import iesfranciscodelosrios.pesetenis.model.dataobject.Consumer;
import iesfranciscodelosrios.pesetenis.model.dataobject.Customer;
import iesfranciscodelosrios.pesetenis.model.dataobject.Producer;

public abstract class Operation {

    protected static Account opsAccount;
    protected static Customer opsCustomer;
    protected static String opsTransactionType;

    protected static Producer producer;

    protected static Consumer consumer;
}
