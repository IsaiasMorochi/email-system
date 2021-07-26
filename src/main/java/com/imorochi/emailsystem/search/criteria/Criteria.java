package com.imorochi.emailsystem.search.criteria;

import java.util.Optional;

public final class Criteria {
    private final Filters           filters;
    private final Optional<Integer> limit;
    private final Optional<Integer> offset;

    public Criteria(Filters filters, Optional<Integer> limit, Optional<Integer> offset) {
        this.filters = filters;
        this.limit   = limit;
        this.offset  = offset;
    }

    public Criteria(Filters filters) {
        this.filters = filters;
        this.limit   = Optional.empty();
        this.offset  = Optional.empty();
    }

    public Filters filters() {
        return filters;
    }

    public Optional<Integer> limit() {
        return limit;
    }

    public Optional<Integer> offset() {
        return offset;
    }

    public boolean hasFilters() {
        return filters.filters().size() > 0;
    }

    public String serialize() {
        return String.format(
            "%s~~%s~~%s~~%s",
            filters.serialize(),
            offset.orElse(0),
            limit.orElse(0)
        );
    }
}
