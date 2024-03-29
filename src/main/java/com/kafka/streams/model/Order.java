package com.kafka.streams.model;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Order extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
    private static final long serialVersionUID = 1422195720914012145L;
    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Order\",\"namespace\":\"com.pluralsight.kafka.streams.model\",\"fields\":[{\"name\":\"userId\",\"type\":\"string\"},{\"name\":\"totalAmount\",\"type\":\"float\"},{\"name\":\"nbOfItems\",\"type\":\"int\"}]}");
    public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

    private static SpecificData MODEL$ = new SpecificData();

    private static final BinaryMessageEncoder<Order> ENCODER =
            new BinaryMessageEncoder<Order>(MODEL$, SCHEMA$);

    private static final BinaryMessageDecoder<Order> DECODER =
            new BinaryMessageDecoder<Order>(MODEL$, SCHEMA$);

    /**
     * Return the BinaryMessageDecoder instance used by this class.
     */
    public static BinaryMessageDecoder<Order> getDecoder() {
        return DECODER;
    }

    /**
     * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
     * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
     */
    public static BinaryMessageDecoder<Order> createDecoder(SchemaStore resolver) {
        return new BinaryMessageDecoder<Order>(MODEL$, SCHEMA$, resolver);
    }

    /** Serializes this Order to a ByteBuffer. */
    public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
        return ENCODER.encode(this);
    }

    /** Deserializes a Order from a ByteBuffer. */
    public static Order fromByteBuffer(
            java.nio.ByteBuffer b) throws java.io.IOException {
        return DECODER.decode(b);
    }

    @Deprecated public java.lang.CharSequence userId;
    @Deprecated public float totalAmount;
    @Deprecated public int nbOfItems;

    /**
     * Default constructor.  Note that this does not initialize fields
     * to their default values from the schema.  If that is desired then
     * one should use <code>newBuilder()</code>.
     */
    public Order() {}

    /**
     * All-args constructor.
     * @param userId The new value for userId
     * @param totalAmount The new value for totalAmount
     * @param nbOfItems The new value for nbOfItems
     */
    public Order(java.lang.CharSequence userId, java.lang.Float totalAmount, java.lang.Integer nbOfItems) {
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.nbOfItems = nbOfItems;
    }

    public org.apache.avro.Schema getSchema() { return SCHEMA$; }
    // Used by DatumWriter.  Applications should not call.
    public java.lang.Object get(int field$) {
        switch (field$) {
            case 0: return userId;
            case 1: return totalAmount;
            case 2: return nbOfItems;
            default: throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }

    // Used by DatumReader.  Applications should not call.
    @SuppressWarnings(value="unchecked")
    public void put(int field$, java.lang.Object value$) {
        switch (field$) {
            case 0: userId = (java.lang.CharSequence)value$; break;
            case 1: totalAmount = (java.lang.Float)value$; break;
            case 2: nbOfItems = (java.lang.Integer)value$; break;
            default: throw new org.apache.avro.AvroRuntimeException("Bad index");
        }
    }

    /**
     * Gets the value of the 'userId' field.
     * @return The value of the 'userId' field.
     */
    public java.lang.CharSequence getUserId() {
        return userId;
    }

    /**
     * Sets the value of the 'userId' field.
     * @param value the value to set.
     */
    public void setUserId(java.lang.CharSequence value) {
        this.userId = value;
    }

    /**
     * Gets the value of the 'totalAmount' field.
     * @return The value of the 'totalAmount' field.
     */
    public java.lang.Float getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the value of the 'totalAmount' field.
     * @param value the value to set.
     */
    public void setTotalAmount(java.lang.Float value) {
        this.totalAmount = value;
    }

    /**
     * Gets the value of the 'nbOfItems' field.
     * @return The value of the 'nbOfItems' field.
     */
    public java.lang.Integer getNbOfItems() {
        return nbOfItems;
    }

    /**
     * Sets the value of the 'nbOfItems' field.
     * @param value the value to set.
     */
    public void setNbOfItems(java.lang.Integer value) {
        this.nbOfItems = value;
    }

    /**
     * Creates a new Order RecordBuilder.
     * @return A new Order RecordBuilder
     */
    public static com.kafka.streams.model.Order.Builder newBuilder() {
        return new com.kafka.streams.model.Order.Builder();
    }

    /**
     * Creates a new Order RecordBuilder by copying an existing Builder.
     * @param other The existing builder to copy.
     * @return A new Order RecordBuilder
     */
    public static com.kafka.streams.model.Order.Builder newBuilder(com.kafka.streams.model.Order.Builder other) {
        return new com.kafka.streams.model.Order.Builder(other);
    }

    /**
     * Creates a new Order RecordBuilder by copying an existing Order instance.
     * @param other The existing instance to copy.
     * @return A new Order RecordBuilder
     */
    public static com.kafka.streams.model.Order.Builder newBuilder(com.kafka.streams.model.Order other) {
        return new com.kafka.streams.model.Order.Builder(other);
    }

    /**
     * RecordBuilder for Order instances.
     */
    public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Order>
            implements org.apache.avro.data.RecordBuilder<Order> {

        private java.lang.CharSequence userId;
        private float totalAmount;
        private int nbOfItems;

        /** Creates a new Builder */
        private Builder() {
            super(SCHEMA$);
        }

        /**
         * Creates a Builder by copying an existing Builder.
         * @param other The existing Builder to copy.
         */
        private Builder(com.kafka.streams.model.Order.Builder other) {
            super(other);
            if (isValidValue(fields()[0], other.userId)) {
                this.userId = data().deepCopy(fields()[0].schema(), other.userId);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.totalAmount)) {
                this.totalAmount = data().deepCopy(fields()[1].schema(), other.totalAmount);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.nbOfItems)) {
                this.nbOfItems = data().deepCopy(fields()[2].schema(), other.nbOfItems);
                fieldSetFlags()[2] = true;
            }
        }

        /**
         * Creates a Builder by copying an existing Order instance
         * @param other The existing instance to copy.
         */
        private Builder(com.kafka.streams.model.Order other) {
            super(SCHEMA$);
            if (isValidValue(fields()[0], other.userId)) {
                this.userId = data().deepCopy(fields()[0].schema(), other.userId);
                fieldSetFlags()[0] = true;
            }
            if (isValidValue(fields()[1], other.totalAmount)) {
                this.totalAmount = data().deepCopy(fields()[1].schema(), other.totalAmount);
                fieldSetFlags()[1] = true;
            }
            if (isValidValue(fields()[2], other.nbOfItems)) {
                this.nbOfItems = data().deepCopy(fields()[2].schema(), other.nbOfItems);
                fieldSetFlags()[2] = true;
            }
        }

        /**
         * Gets the value of the 'userId' field.
         * @return The value.
         */
        public java.lang.CharSequence getUserId() {
            return userId;
        }

        /**
         * Sets the value of the 'userId' field.
         * @param value The value of 'userId'.
         * @return This builder.
         */
        public com.kafka.streams.model.Order.Builder setUserId(java.lang.CharSequence value) {
            validate(fields()[0], value);
            this.userId = value;
            fieldSetFlags()[0] = true;
            return this;
        }

        /**
         * Checks whether the 'userId' field has been set.
         * @return True if the 'userId' field has been set, false otherwise.
         */
        public boolean hasUserId() {
            return fieldSetFlags()[0];
        }


        /**
         * Clears the value of the 'userId' field.
         * @return This builder.
         */
        public com.kafka.streams.model.Order.Builder clearUserId() {
            userId = null;
            fieldSetFlags()[0] = false;
            return this;
        }

        /**
         * Gets the value of the 'totalAmount' field.
         * @return The value.
         */
        public java.lang.Float getTotalAmount() {
            return totalAmount;
        }

        /**
         * Sets the value of the 'totalAmount' field.
         * @param value The value of 'totalAmount'.
         * @return This builder.
         */
        public com.kafka.streams.model.Order.Builder setTotalAmount(float value) {
            validate(fields()[1], value);
            this.totalAmount = value;
            fieldSetFlags()[1] = true;
            return this;
        }

        /**
         * Checks whether the 'totalAmount' field has been set.
         * @return True if the 'totalAmount' field has been set, false otherwise.
         */
        public boolean hasTotalAmount() {
            return fieldSetFlags()[1];
        }


        /**
         * Clears the value of the 'totalAmount' field.
         * @return This builder.
         */
        public com.kafka.streams.model.Order.Builder clearTotalAmount() {
            fieldSetFlags()[1] = false;
            return this;
        }

        /**
         * Gets the value of the 'nbOfItems' field.
         * @return The value.
         */
        public java.lang.Integer getNbOfItems() {
            return nbOfItems;
        }

        /**
         * Sets the value of the 'nbOfItems' field.
         * @param value The value of 'nbOfItems'.
         * @return This builder.
         */
        public com.kafka.streams.model.Order.Builder setNbOfItems(int value) {
            validate(fields()[2], value);
            this.nbOfItems = value;
            fieldSetFlags()[2] = true;
            return this;
        }

        /**
         * Checks whether the 'nbOfItems' field has been set.
         * @return True if the 'nbOfItems' field has been set, false otherwise.
         */
        public boolean hasNbOfItems() {
            return fieldSetFlags()[2];
        }


        /**
         * Clears the value of the 'nbOfItems' field.
         * @return This builder.
         */
        public com.kafka.streams.model.Order.Builder clearNbOfItems() {
            fieldSetFlags()[2] = false;
            return this;
        }

        @Override
        @SuppressWarnings("unchecked")
        public Order build() {
            try {
                Order record = new Order();
                record.userId = fieldSetFlags()[0] ? this.userId : (java.lang.CharSequence) defaultValue(fields()[0]);
                record.totalAmount = fieldSetFlags()[1] ? this.totalAmount : (java.lang.Float) defaultValue(fields()[1]);
                record.nbOfItems = fieldSetFlags()[2] ? this.nbOfItems : (java.lang.Integer) defaultValue(fields()[2]);
                return record;
            } catch (java.lang.Exception e) {
                throw new org.apache.avro.AvroRuntimeException(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumWriter<Order>
            WRITER$ = (org.apache.avro.io.DatumWriter<Order>)MODEL$.createDatumWriter(SCHEMA$);

    @Override public void writeExternal(java.io.ObjectOutput out)
            throws java.io.IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    @SuppressWarnings("unchecked")
    private static final org.apache.avro.io.DatumReader<Order>
            READER$ = (org.apache.avro.io.DatumReader<Order>)MODEL$.createDatumReader(SCHEMA$);

    @Override public void readExternal(java.io.ObjectInput in)
            throws java.io.IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

}
