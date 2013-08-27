use XMLRPC::Transport::HTTP;
my $facadeserver = XMLRPC::Transport::HTTP::CGI
      -> dispatch_to('PerlSystemFacade')
      -> handle;