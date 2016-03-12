package com.thinhvo.generalproject.repository.impl;

import com.thinhvo.generalproject.domain.Account;
import com.thinhvo.generalproject.repository.AccountRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Thinh Vo on 3/9/2016.
 * All repository impl should extend BaseRepository and implement their interface XXXRepository
 */
@Repository
public class AccountRepositoryImpl extends BaseRepositoryImpl<Account, Integer> implements AccountRepository {
}
