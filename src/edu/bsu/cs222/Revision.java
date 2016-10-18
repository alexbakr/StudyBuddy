package edu.bsu.cs222;

public class Revision {
    public static final class Builder {
        private int sleep;

        private Builder() {}

        public Builder setSleep(int sleep) {
            this.sleep = sleep;
            return this;
        }

        public Revision build() { return new Revision(this); }
    }
    public static Builder create() { return new Builder(); }

    public final int sleep;

    public Revision(Builder builder) {
        this.sleep = builder.sleep;
    }
}