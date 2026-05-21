ika lekukhipha ukucindezela ingavumelekile.
 *
 * 3. Ukululeka
 *    - Ngoziwapheka i-ctx->temp_buffer: kuhluleka lwefomethi i-data_size, ukululeka lwefomethi i-data_size, kuhluleka ngoziwapheka i-data_size, singa ukululeka.
 *    - I-header i-data_size na-payload ukululeka, ukululeka ngoziwapheka i-data_size na-payload, ukululeka ngoziwapheka i-data_size na-payload, singa ukululeka.
 *
 * 4. Lwefomethi I-data_size
 *    - I-data_size lwefomethi i-data_size na-payload i-ctx->temp_buffer, ukululeka.
 *
 * 5. I-data_size na-payload
 *    - Na-payload ukululeka.
 */

#endif  // COMPRESSION_TOOL_H
"""

#===================================================================================================
# The following code is executed after the plugins have been loaded.
#===================================================================================================

#---------------------------------------------------------------------------------------------------
# i-temporary buffer
#---------------------------------------------------------------------------------------------------

print
print "* I-temporary buffer"
print "* i-temporary buffer: %s" % str(tmp_buffer)
print


#---------------------------------------------------------------------------------------------------
# i-header
#---------------------------------------------------------------------------------------------------

print
print "* I-header"
print "* i-header: %s" % str(header)
print


#---------------------------------------------------------------------------------------------------
# i-payload
#---------------------------------------------------------------------------------------------------

print
print "* I-payload"
print "* i-payload: %s" % str(payload)
print


#---------------------------------------------------------------------------------------------------
# i-checksum
#---------------------------------------------------------------------------------------------------

print
print "* I-checksum"
print "* i-checksum: %s" % str(checksum)
print


#---------------------------------------------------------------------------------------------------
# i-