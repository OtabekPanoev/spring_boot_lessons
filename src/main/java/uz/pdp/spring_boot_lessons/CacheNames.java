package uz.pdp.spring_boot_lessons;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class CacheNames {
    public static final String MESSAGE_BY_KEY = "message_by_key";
    public static final String MESSAGE_BY_ALL_KEYS = "message_by_all_keys";
    public static final String MESSAGE_BY_GROUP = "message_by_group";
    public static final String MESSAGE_BY_BANNER_TYPE= "message_by_banner_type";
    public static final String MESSAGE_BY_LOAN= "message_by_loan";

    public static final String KEY_BY_LOAN_SEARCH= "key_by_loan_search";
    public static final String KEY_BY_LOAN_SCHEDULE= "key_by_loan_schedule";
    public static final String KEY_BY_LOAN_STATEMENT= "key_by_loan_statement";


    public static final Map<String, Long> EXPIRATIONS = Map.of(
            "message", 60L,
            CacheNames.MESSAGE_BY_KEY, -1L,
            CacheNames.MESSAGE_BY_ALL_KEYS, -1L,
            CacheNames.MESSAGE_BY_GROUP, -1L,
            CacheNames.MESSAGE_BY_BANNER_TYPE, -1L,
            CacheNames.MESSAGE_BY_LOAN, -1L,
            CacheNames.KEY_BY_LOAN_SEARCH, 86400L,
            CacheNames.KEY_BY_LOAN_SCHEDULE, 86400L,
            CacheNames.KEY_BY_LOAN_STATEMENT, 86400L
    );
}
