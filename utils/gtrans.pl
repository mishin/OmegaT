#!/usr/bin/env perl
use Modern::Perl;
use YAML::Tiny;
use LWP::UserAgent;
use URI::Escape;
use HTML::Entities;
use Encode;
use DDP;
use Convert::Cyrillic;

main();

sub main {
    my $yaml = load_conf('gtrans.yml');
    translate_text( $yaml, $ARGV[0] );
}

sub translate_text {
    my $yaml  = shift;
    my $words = shift;

    my $url =
        'http://translate.google.com/translate_t?langpair='
      . $yaml->{from} . '|'
      . $yaml->{to}
      . '&text=' . '+'
      . $words;
    my $ua = LWP::UserAgent->new;
    $ua->agent('');
    my $res = $ua->get($url);

    if ( $res->is_success ) {

        my @matches =
          ( $res->content =~

m{onmouseout="this.style.backgroundColor='#fff'">(.*?)</span>}g
#m{ onmouseout="this.style.backgroundColor='#fff'">(.*?)</span>}g
#m{onmouseover="this.style.backgroundColor='#ebeff9'" onmouseout="this.style.backgroundColor='#fff'">(.*?)</span>}g

          );

        foreach my $translated_string (@matches) {

            my $interm_var =
              Convert::Cyrillic::cstocs( 'KOI8', 'UTF8', $translated_string );
            my $rez = Encode::from_to( $interm_var, 'utf-8', 'cp1251' );
            say $interm_var;

        }
#say $res->content;
    }
    else {
        die $res->status_line;
    }

}

sub load_conf {
    my $config = shift;
    my $yaml   = YAML::Tiny::LoadFile($config);
    return $yaml;
}

__DATA__

gtrans.yml

from: en
to: ru
word: word
